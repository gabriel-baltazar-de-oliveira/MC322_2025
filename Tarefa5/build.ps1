# 1. Compilar o codigo fonte:
Write-Host "1. Compilando o codigo fonte..."

# --- LÓGICA DE BUSCA DA BIBLIOTECA ---
$jarFilename = "junit-platform-console-standalone-1.10.2.jar"

# Caminho 1: Pasta de Downloads do usuário (ex: C:\Users\gbiel\Downloads)
$downloadsJarPath = Join-Path $env:USERPROFILE "Downloads\$jarFilename"

# Caminho 2: Pasta 'lib' local (relativa ao script)
$localLibJarPath = "lib\$jarFilename"

$junitJar = "" # Inicializa a variável

# Procura a biblioteca...
if (Test-Path $downloadsJarPath) {
    Write-Host "Biblioteca JUnit encontrada na pasta Downloads." -ForegroundColor Green
    $junitJar = $downloadsJarPath
} elseif (Test-Path $localLibJarPath) {
    Write-Host "Biblioteca JUnit encontrada na pasta 'lib' local." -ForegroundColor Green
    $junitJar = $localLibJarPath
} else {
    # Se não encontrar em nenhum dos lugares, falha.
    Write-Host "ERRO: Biblioteca '$jarFilename' não encontrada!" -ForegroundColor Red
    Write-Host "Por favor, coloque o arquivo .jar na sua pasta 'Downloads' ou numa pasta 'lib' local." -ForegroundColor Yellow
    exit 1
}
# --- FIM DA LÓGICA DE BUSCA ---


# O resto do script usa a variável $junitJar, que agora tem o caminho correto
$sourceFiles = Get-ChildItem -Path src, test -Recurse -Filter *.java | ForEach-Object { $_.FullName }

# O comando do compilador (javac)
javac -encoding UTF-8 -d bin -sourcepath "src;test" --class-path $junitJar $sourceFiles

if (-not $?) {
    Write-Host "ERRO NA COMPILACAO. Abortando script." -ForegroundColor Red
    exit 1
}

Write-Host "Compilacao concluida."
Write-Host ""

# Define a variável de ambiente para corrigir a acentuação
$env:JAVA_TOOL_OPTIONS = "-Dfile.encoding=UTF-8"

# 2. Executar o programa: (Comentado, como você pediu)
# Write-Host "2. Executando o programa..."
# java -cp bin com.rpg.game.Main
# Write-Host ""

# 3. Executar os testes:
Write-Host "3. Executando os testes..."

java -jar $junitJar --class-path "bin" --scan-classpath
Write-Host ""

# Limpa a variável de ambiente
Remove-Item Env:JAVA_TOOL_OPTIONS

Write-Host "Script concluido."
