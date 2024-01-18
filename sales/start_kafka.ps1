# Caminho para o diretório do Kafka
$KAFKA_DIR = "C:/kafka"

Clear-Host

$porta = 9092
$processo = Get-NetTCPConnection -LocalPort $porta -ErrorAction SilentlyContinue | Select-Object -ExpandProperty OwningProcess

if ($processo) {
    Stop-Process -Id $processo -Force
    Write-Host "O processo com a porta $porta foi encerrado."
} else {
    Write-Host "Nenhum processo encontrado na porta $porta."
}

# Comando para iniciar o servidor Kafka
#Start-Process -FilePath "$KAFKA_DIR/bin/windows/kafka-server-start.bat" -ArgumentList "$KAFKA_DIR/config/server.properties" -NoNewWindow
