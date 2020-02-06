
package com.codeabovelab.dm.agent.security;

import org.bouncycastle.cert.X509v3CertificateBuilder;

public interface CertBuilderHandler {
    void handle(X509v3CertificateBuilder cb);
}
