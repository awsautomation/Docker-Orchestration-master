/*
 * Copyright 2016 Code Above Lab LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeabovelab.dm.mail.template;

import com.codeabovelab.dm.mail.dto.MailMessage;
import com.codeabovelab.dm.mail.dto.MailSource;
import com.codeabovelab.dm.mail.dto.MailTemplate;

import java.util.Set;

/**
 * Engine which fill specified template with data from source.
 */
public interface MailTemplateEngine {
    /**
     * Set of provided engines
     * @return
     */
    Set<String> getProvidedEngines();

    /**
     * Do fill of template with specified source.
     * @param mailTemplate
     * @param source
     * @return
     */
    MailMessage create(MailTemplate mailTemplate, MailSource source);
}
