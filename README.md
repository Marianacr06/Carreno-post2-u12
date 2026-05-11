# Patrones de Diseno de Software - U12 Post 2

## Objetivo
Validar la arquitectura con ArchUnit, documentar decisiones con ADR y ejecutar reglas en GitHub Actions.

## Estructura
- src/main/java/com/empresa/pedidos/
- src/test/java/com/empresa/pedidos/
- img/ (capturas)

## Base
Este repositorio parte del sistema de pedidos del Post 1 (Factory, Strategy, Observer, Facade).

## Ejecucion
```bash
mvn clean verify
mvn clean verify sonar:sonar -Dsonar.projectKey=pedidos-integrado -Dsonar.host.url=http://localhost:9000 -Dsonar.login=TU_TOKEN
```

## Validacion Arquitectonica
Reglas ArchUnit incluidas en `ReglasArquitectura`:
1. Dominio aislado de infraestructura y adaptadores.
2. Controladores solo acceden a la Facade.
3. Puertos de dominio son interfaces.
4. Procesadores implementan `ProcesadorPedido`.
5. Infraestructura no accede a adaptadores REST.

## ADR
Se documentan tres decisiones en `docs/adr/`:
- ADR-001: Arquitectura Hexagonal.
- ADR-002: Factory + Strategy para seleccion de procesador.
- ADR-003: Observer con Spring Events para notificaciones.

## Pipeline
El workflow `.github/workflows/arquitectura.yml` ejecuta las reglas de ArchUnit y la suite completa en cada push.

## Evidencias
- img/pipeline-rojo.png
- img/pipeline-verde.png
