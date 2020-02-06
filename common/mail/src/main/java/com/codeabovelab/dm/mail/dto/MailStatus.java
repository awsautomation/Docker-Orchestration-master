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

package com.codeabovelab.dm.mail.dto;

/**
 * Enum of possible mail statuses.
*/
public enum MailStatus {
    /**
     * Message success passed to mail server.
     */
    OK(false),
    /**
     * Message success queued.
     */
    QUEUED(false),
    /**
     * Unknown fail.
     */
    UNKNOWN_FAIL(true);

    private final boolean error;

    MailStatus(boolean error) {
        this.error = error;
    }

    /**
     * This method allow us to distinguish error statuses.
     * @return
     */
    public boolean isError() {
        return error;
    }
}
