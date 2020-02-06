
package com.codeabovelab.dm.cluman.job;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 */
@Component
@ConditionalOnBean(JobParameterDescriptionSerializer.class)
public class JobJacksonModule extends Module {

    private JobParameterDescriptionSerializer jobParameterDescriptionSerializer;

    @Autowired(required = false)
    public void setJobParameterDescriptionSerializer(JobParameterDescriptionSerializer jobParameterDescriptionSerializer) {
        this.jobParameterDescriptionSerializer = jobParameterDescriptionSerializer;
    }

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
    }

    @SuppressWarnings("unchecked")
    private void addDeserializers(SimpleDeserializers deserializers) {
    }

    private void addSerializers(SimpleSerializers serializers) {
        if(jobParameterDescriptionSerializer != null) {
            serializers.addSerializer(JobParameterDescription.class, jobParameterDescriptionSerializer);
        }
    }

}
