# wso2Training
## Message Builder
### Build
`mvn clean install`
### deploy
Copy the jar file in `target/` directory to `<micro-integrator-home/lib`. Restart of the server is required.

## Soap Service
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
class = "cz.vojtechkrakora.wso2.training.CoolMessageBuilder"
content_type = "image/png"
```