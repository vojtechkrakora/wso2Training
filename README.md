# wso2Training

## List all deployed services
`http://localhost:8290/services`

## Configuration
### Receiving image/png
Add configuration to deployment.toml
```
[[custom_message_formatters]]
class = "org.wso2.carbon.relay.ExpandingMessageFormatter"
content_type = "image/png"

[[custom_message_builders]]
class = "org.wso2.carbon.relay.BinaryRelayBuilder"
content_type = "image/png"
```