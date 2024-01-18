# Caminho para o diretório do Kafka
$KAFKA_DIR = "C:/kafka"

Clear-Host

$porta = 2181
$processo = Get-NetTCPConnection -LocalPort $porta -ErrorAction SilentlyContinue | Select-Object -ExpandProperty OwningProcess

if ($processo) {
    Stop-Process -Id $processo -Force
    Write-Host "O processo com a porta $porta foi encerrado."
} else {
    Write-Host "Nenhum processo encontrado na porta $porta."
}

# Comando para iniciar o servidor ZooKeeper
#Start-Process -FilePath "$KAFKA_DIR/bin/windows/zookeeper-server-start.bat" -ArgumentList "$KAFKA_DIR/config/zookeeper.properties" -NoNewWindow

#.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties