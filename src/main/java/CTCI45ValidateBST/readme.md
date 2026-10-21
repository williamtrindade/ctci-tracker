# 4.5 Validate BST — Validar BST

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 4, questão/question **4.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Regras (como no livro):** para todo nó, **todos** os nós da subárvore esquerda são `<=` ao nó e todos da
subárvore direita são `>` (duplicatas só podem ficar à esquerda). Árvore vazia é BST. Cuidado com nós contendo
`Integer.MIN_VALUE` / `Integer.MAX_VALUE`.

**Assinatura:** `boolean checkBST(TreeNode root)`
