# Caminho para o diretório do Kafka
$KAFKA_DIR = "C:/kafka"

# Limpar o console
Clear-Host

# Comando para iniciar o servidor ZooKeeper
Start-Process -FilePath "$KAFKA_DIR/bin/windows/zookeeper-server-start.bat" -ArgumentList "$KAFKA_DIR/config/zookeeper.properties" -NoNewWindow
