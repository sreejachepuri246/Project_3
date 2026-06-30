// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class SudokuSolver {
   public SudokuSolver() {
   }

   public static boolean solveSudoku(int[][] var0) {
      for(int var1 = 0; var1 < 9; ++var1) {
         for(int var2 = 0; var2 < 9; ++var2) {
            if (var0[var1][var2] == 0) {
               for(int var3 = 1; var3 <= 9; ++var3) {
                  if (isSafe(var0, var1, var2, var3)) {
                     var0[var1][var2] = var3;
                     if (solveSudoku(var0)) {
                        return true;
                     }

                     var0[var1][var2] = 0;
                  }
               }

               return false;
            }
         }
      }

      return true;
   }

   public static boolean isSafe(int[][] var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < 9; ++var4) {
         if (var0[var1][var4] == var3) {
            return false;
         }
      }

      for(int var8 = 0; var8 < 9; ++var8) {
         if (var0[var8][var2] == var3) {
            return false;
         }
      }

      int var9 = var1 - var1 % 3;
      int var5 = var2 - var2 % 3;

      for(int var6 = 0; var6 < 3; ++var6) {
         for(int var7 = 0; var7 < 3; ++var7) {
            if (var0[var9 + var6][var5 + var7] == var3) {
               return false;
            }
         }
      }

      return true;
   }

   public static void printBoard(int[][] var0) {
      for(int var1 = 0; var1 < 9; ++var1) {
         for(int var2 = 0; var2 < 9; ++var2) {
            System.out.print(var0[var1][var2] + " ");
         }

         System.out.println();
      }

   }

   public static void main(String[] var0) {
      int[][] var1 = new int[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
      System.out.println("Original Sudoku:");
      printBoard(var1);
      if (solveSudoku(var1)) {
         System.out.println("\nSolved Sudoku:");
         printBoard(var1);
      } else {
         System.out.println("No solution exists.");
      }

   }
}
