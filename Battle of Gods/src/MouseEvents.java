import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEvents extends MouseAdapter {

	public void mouseClicked(MouseEvent e){
		
		for( int x = 0; x < getBoard().getsize(); x++ ){
			for ( int y = 0; y < getBoard().getsize(); y++ ) {

				if( gameCases[y][x] == e.getSource() ) {
					gameGods[y][x].setIcon(gods[1]);
				}
			}
		}
	}
}
