/*
 * Copyright (C) 2016 Red Hat, Inc.
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
package io.syndesis.integration.runtime.capture;

import io.syndesis.integration.runtime.OutMessageCaptureInterceptStrategy;
import org.apache.camel.spi.InterceptStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "syndesis.integration.runtime.capture", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(MessageCaptureConfiguration.class)
public class MessageCaptureAutoConfiguration {
    @Bean
    public InterceptStrategy outMessageCaptureInterceptStrategy() {
        return new OutMessageCaptureInterceptStrategy();
    }
}
