# Caminho para o diretório do Kafka
$KAFKA_DIR = "C:/kafka"

# Limpar o console
Clear-Host

# Comando para iniciar o servidor Kafka
Start-Process -FilePath "$KAFKA_DIR/bin/windows/kafka-server-start.bat" -ArgumentList "$KAFKA_DIR/config/server.properties" -NoNewWindow
