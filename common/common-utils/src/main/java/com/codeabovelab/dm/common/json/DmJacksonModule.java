

package com.codeabovelab.dm.common.json;

import com.codeabovelab.dm.common.utils.Keeper;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.springframework.util.MimeType;


public class DmJacksonModule extends Module {

 
    @Override
    public String getModuleName() {
        return getClass().getName();
    }


    @Override
    public Version version() {
        return new Version(1, 0, 0, null, null, null);
    }

 
    @Override
    public void setupModule(SetupContext setupContext) {
        SimpleSerializers serializers = new SimpleSerializers();
        addSerializers(serializers);
        setupContext.addSerializers(serializers);

        SimpleDeserializers deserializers = new SimpleDeserializers();
        addDeserializers(deserializers);
        setupContext.addDeserializers(deserializers);
        setupContext.addBeanDeserializerModifier(new KeeperBeanDeserializerModifier());
    }

    @SuppressWarnings("unchecked")
    private void addDeserializers(SimpleDeserializers deserializers) {
        deserializers.addDeserializer(MimeType.class, new MimeTypeDeserializer());
        deserializers.addDeserializer(Keeper.class, (JsonDeserializer) new KeeperDeserializer());
    }

    private void addSerializers(SimpleSerializers serializers) {
        serializers.addSerializer(MimeType.class, new MimeTypeSerializer());
        serializers.addSerializer(Keeper.class, new KeeperSerializer());
    }

}
