plugins {
    `java-library`
    `maven-publish`
}

group = "br.com.goodbank"
version = (findProperty("version") as String?)?.takeIf { it != "unspecified" } ?: "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
    withSourcesJar()
}

repositories {
    mavenCentral()
}

val springBootVersion = "4.1.2"

dependencies {
    // Tabela de versões do Spring Boot (não vira dependência)
    compileOnly(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
    annotationProcessor(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
    compileOnly("ch.qos.logback:logback-classic") // versão vem do BOM
    // Spring como pré-requisito (quem usa a lib fornece)
    compileOnly("org.springframework.boot:spring-boot-autoconfigure")
    compileOnly("org.springframework.boot:spring-boot-restclient")
    compileOnly("org.springframework:spring-web")
    compileOnly("org.slf4j:slf4j-api") // versão vem do BOM
    compileOnly("jakarta.validation:jakarta.validation-api")
    compileOnly("jakarta.servlet:jakarta.servlet-api") // versão vem do BOM
    // Autocomplete do application.yml
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // Testes da própria lib (JUnit já vem pelo spring-boot-starter-test)
    testImplementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-restclient")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // Mesmas dependências que uma aplicação consumidora desta lib precisa adicionar
    // (jakarta.validation-api/servlet-api são compileOnly no main). Trazidas aqui para
    // os testes exercitarem o comportamento real de binding/validação e do filtro servlet.
    testImplementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("jakarta.servlet:jakarta.servlet-api")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "goodbank-core"
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/goodbankdev/goodbank-core")
            credentials {
                username = findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}