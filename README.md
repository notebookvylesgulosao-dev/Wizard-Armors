# Wandry HP — Minecraft Java 1.21.4 / Fabric

Projeto-fonte em Java 21. Os `.bbmodel` originais ficam em `source_models/`; `tools/convert_models.py` gera os assets a partir deles.

## Implementado
- Registro das sete varinhas, chapéu, vassoura e pergaminho; aba criativa e traduções pt-BR; receitas de Bone, Magma e Celestial.
- **Chapéu**: slot da cabeça, +5 corações, 15% menos repulsão, +30% de velocidade; modelo original (UV corrigida) e `display` do Blockbench.
- **Vassoura**: entidade montável (`BroomEntity`). Usar o item invoca e monta. W/A/S/D movem na direção do olhar, Espaço sobe, Ctrl desce, 5 blocos/s. Shift desmonta e devolve o item; bater na vassoura vazia também recupera.
- **Projéteis** (`SpellProjectileEntity`): modelos originais dos 7 feitiços e dos 5 props, rastro do feitiço + rastro da varinha, colisão com bloco/entidade (somente visual, sem dano).
- **Controles da varinha**: botão direito lança o feitiço escolhido na roda (recarga existente); botão esquerdo lança o ataque base (prop). Emerald usa o prop do Amethyst e Magma o do Dragon (teste).
- **Roda de feitiços** (tecla G): anel com os 7 feitiços; clique ou teclas 1-7 escolhem o feitiço da varinha na mão (salvo no próprio item).

## Não implementado
Classes Good/Evil/Normal, loot de pergaminhos em estruturas, animação de braço, dano/efeitos dos feitiços.

## Notas
- Modelos com rotação em mais de um eixo (props, um elemento do Petrificus) não cabem no JSON de item; por isso projéteis e a vassoura em entidade usam `assets/wandry_hp/quads/*.json`, desenhados por `client/QuadModel`.
- Esta versão não foi compilada nem testada.

## Compilar
JDK 21 e Gradle 8.x; `gradle build` gera o JAR em `build/libs/`.
