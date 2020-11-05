# wso2Training
## About
This project creates Soap service in a WSO2. The service has exposed custom WSDL with inline schema.

## Purpose
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
content_type = "image/png"

[[custom_message_builders]]
class = "org.wso2.carbon.relay.BinaryRelayBuilder"
content_type = "image/png"
```
