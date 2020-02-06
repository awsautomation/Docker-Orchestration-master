
package com.codeabovelab.dm.agent.security;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.google.common.collect.ImmutableSet;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.security.KeyPair;
import java.security.Security;

import static com.codeabovelab.dm.agent.security.CertificateGenerator.createCert;
import static com.codeabovelab.dm.agent.security.CertificateGenerator.createKeypair;
import static org.junit.Assert.*;

public class CertificateGeneratorTest {
    @Test
    public void constructCert() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        ((Logger)LoggerFactory.getLogger(CertificateGenerator.class)).setLevel(Level.DEBUG);
        File file = new File("/tmp/dm-agent.jks");//Files.createTempFile("dm-agent", ".jks");

        KeyPair keypair = createKeypair();
        JcaX509v3CertificateBuilder cb = createRootCert(keypair);
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(keypair.getPrivate());
        X509CertificateHolder rootCert = cb.build(signer);
        KeystoreConfig cert = CertificateGenerator.constructCert(rootCert,
          keypair.getPrivate(),
          file,
          ImmutableSet.of("test1", "test2"));
        assertNotNull(cert);
    }


    private static JcaX509v3CertificateBuilder createRootCert(KeyPair keypair) throws Exception {
        X500NameBuilder ib = new X500NameBuilder(RFC4519Style.INSTANCE);
        ib.addRDN(RFC4519Style.c, "AQ");
        ib.addRDN(RFC4519Style.o, "Test");
        ib.addRDN(RFC4519Style.l, "Vostok Station");
        ib.addRDN(PKCSObjectIdentifiers.pkcs_9_at_emailAddress, "test@gmail.com");
        X500Name issuer = ib.build();
        return createCert(keypair, issuer, issuer);
    }

}