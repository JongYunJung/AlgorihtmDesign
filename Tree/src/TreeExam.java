

public class TreeExam {

	public static void main(String[] args)	{

		Tree.fileName = "tree_input.txt";
		Tree.readInput();
		Tree.preorder(1); System.out.print('\n');
		Tree.inorder(1); System.out.print('\n');		
		Tree.postorder(1); System.out.print('\n');
		Tree.bfs(1); System.out.print('\n');
		System.out.printf("Ʈ���� ���� = %d\n", Tree.tree_height(1));
		System.out.printf("Ʈ���� ũ�� = %d\n", Tree.tree_size(1));
		
	}

}
