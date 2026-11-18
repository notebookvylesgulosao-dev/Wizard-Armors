# ArmorPlus — Fabric 1.21.4

Projeto-fonte para Java 21 / Fabric 1.21.4.

## Peças (valores de armadura)
| Peça | Slot | Armadura |
|---|---|---|
| Cachecol (`armorplus:cachecol`) | cabeça | +1 |
| Sobretudo (`armorplus:sobretudo`) | peitoral | +2 |
| Calça (`armorplus:calca`) | pernas | +2 |
| Botas (`armorplus:botas`) | pés | +2 |

Total do conjunto: 7 pontos de armadura. As peças aparecem na aba **Combate** do modo criativo.

## Bônus do conjunto completo
Aplicado somente enquanto as **quatro** peças estão equipadas:
- +4 corações de vida máxima (+8 pontos)
- +30% de velocidade de movimento
- 15% menos repulsão (knockback resistance 0.15)

Ao tirar qualquer peça, os três bônus são removidos.

## Texturas
Os arquivos atuais são **provisórios** (cores sólidas) só para o jogo não exibir o padrão rosa/preto. Substitua pelos definitivos, mantendo os mesmos nomes:
- Ícones: `assets/armorplus/textures/item/{cachecol,sobretudo,calca,botas}.png` (16x16)
- Armadura vestida: `assets/armorplus/textures/entity/equipment/humanoid/uniforme.png` (cabeça, peitoral, botas) e `.../humanoid_leggings/uniforme.png` (calça), 64x32.

## Compilar
Com JDK 21 e Gradle: `gradle build` — o JAR sai em `build/libs/`.
