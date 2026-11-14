package br.com.goodbank.core;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "goodbank")
public record AppProperties(

        @NotBlank(message = "é obrigatório")
        @Pattern(regexp = "^[a-z0-9-]{3,40}$",
                message = "deve ter de 3 a 40 caracteres: letras minúsculas, números e hífen")
        String appId
) {}