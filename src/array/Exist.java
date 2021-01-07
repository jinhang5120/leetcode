package array;

public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean exist = exist(board, "ABCESEEEFS");
        System.out.println("exist = " + exist);
    }
/*
    [["A","B","C","E"],
    ["S","F","E","S"],
    ["A","D","E","E"]]
"ABCESEEEFS"
*/
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean flag = false;
        for(int i=0;!flag&&i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==chars[0]){
                    int x = i,y = j;
                    boolean[][] isVisited = new boolean[board.length][board[0].length];
                    check(board,i,j,isVisited,chars,1);
                    if(checked){
                        flag=true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
    public static boolean checked = false;
    public static void check(char[][] board,int x,int y,boolean[][] isVisited,char[] chars,int cur){
        if(cur==chars.length){
            checked = true;
        }
        if (!checked) {
            isVisited[x][y] = true;
            if(x>0&&!isVisited[x-1][y]&&board[x-1][y]==chars[cur]){
                check(board,x-1,y,isVisited,chars,cur+1);
            }
            if(x<board.length-1&&!isVisited[x+1][y]&&board[x+1][y]==chars[cur]){
                check(board,x+1,y,isVisited,chars,cur+1);
            }
            if(y>0&&!isVisited[x][y-1]&&board[x][y-1]==chars[cur]){
                check(board,x,y-1,isVisited,chars,cur+1);
            }
            if(y<board[0].length-1&&!isVisited[x][y+1]&&board[x][y+1]==chars[cur]){
                check(board,x,y+1,isVisited,chars,cur+1);
            }
        }
    }
}
