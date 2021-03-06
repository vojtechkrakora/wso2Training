# wso2Training
*Version 1.0.3-SNAPSHOT*
## Message Builder
### Build
`mvn clean install`
### deploy
Copy the jar file in `target/` directory to `<micro-integrator-home/lib`. Restart of the server is required.

## Soap Service
### About
This project creates Soap service in a WSO2. The service has exposed custom WSDL with inline schema.

### Purpose
The main purpose is to create a Soap service which gets some `application/png` data and returns with mtom.

## Micro-Integrator
### List all deployed services
`http://localhost:8290/services`

### Configuration
#### Receiving image/png
Add configuration to deployment.toml
```
[[custom_message_formatters]]
class = "org.wso2.carbon.relay.ExpandingMessageFormatter"
content_type = "multipart/related"

[[custom_message_builders]]
class = "cz.vojtechkrakora.wso2.training.CoolMessageBuilder"
content_type = "image/png"
```
