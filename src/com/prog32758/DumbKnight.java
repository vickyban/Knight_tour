package com.prog32758;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DumbKnight
 */
@WebServlet("/DumbKnight")
public class DumbKnight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DumbKnight() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int num = Integer.parseInt(request.getParameter("num"));
		int count = 0;
		ArrayList<Knight> knights = new ArrayList<>();
		try {
			File file = new File("vickyNonIntelligentMethod.txt");
			if(!file.exists())
				file.createNewFile();
			System.out.println(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("Results of Non Intelligence approach of the Knight Tour problem ");
			bw.newLine();
			bw.newLine();
			
			while(++count <= num) {
				Knight knight = new Knight();
				knights.add(knight);
				
				knight.setInitPost(x, y);
				knight.runDumpKnight();
				bw.write("Trial " + count + ": The Knight was able to successfully touch " + knight.getStep() + " squares." );
				bw.newLine();
				
				int[][] board = knight.getBoard();
				
				for(int i = 0; i< 8; i++){
		                for(int j = 0; j < 8; j++){
		                    String n = board[i][j] < 10 ? " " + board[i][j] + " " : board[i][j] + " " ;
		                    bw.write(n);
		                }
		                bw.newLine();
		            }
				 bw.newLine();
				 bw.newLine();
			}
            bw.close();

		}catch(IOException err) {
			System.out.println(err);
		}
		
		request.setAttribute("title", "Non Intelligent Method");
		request.setAttribute("knights", knights);
		request.getRequestDispatcher("runKnightTour.jsp").forward(request, response);;
		
	}

}
