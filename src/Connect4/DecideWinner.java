package Connect4;

import boardScreen.Player;
import boardScreen.Round;
import boardScreen.XYAxes;
import boardScreen.playerEvents;
import playersScreen.PlayerList;

import java.awt.*;
import java.util.Arrays;

public class DecideWinner {

        public DecideWinner(int numberPlayers, boolean versus, Player[] call) {
                this.call = call;
                this.versus = versus;
                this.numberPlayers=numberPlayers;
        }
        private Player[] call;
        private boolean versus;
        private int gameNumber=1;
        public int numberPlayers;
        public int[] scores=new int[]{0, 0, 0, 0};
        int advancesRound1;
        int advancesRound2;
        public int[] playingIs=new int[ 2 ];

        private void actInScores(String color) {
                if ( numberPlayers==2 ) {
                        if ( color.equals ("red") ) {
                                scores[ 1 ]=10;
                        } else {
                                scores[ 0 ]=10;
                        }
                } else {
                        if ( numberPlayers==3 ) {
                                if ( gameNumber==1 ) {
                                        if ( color.equals ("red") ) {
                                                advancesRound1=1;
                                                playingIs[ 0 ]=1;
                                                playingIs[ 1 ]=2;
                                        } else {
                                                advancesRound1=0;
                                                playingIs[ 0 ]=0;
                                                playingIs[ 1 ]=2;
                                        }
                                        gameNumber++;
                                } else {
                                        if ( color.equals ("red") ) {
                                                scores[ 2 ]=10;
                                        } else {
                                                scores[ advancesRound1 ]=10;
                                        }
                                }
                        } else {
                                if ( gameNumber==1 ) {
                                        if ( color.equals ("red") ) {
                                                advancesRound1=1;
                                        } else {
                                                advancesRound1=0;
                                        }
                                        gameNumber++;
                                        playingIs[ 0 ]=2;
                                        playingIs[ 1 ]=3;
                                } else {
                                        if ( gameNumber==2 ) {
                                                if ( color.equals ("red") ) {
                                                        advancesRound2=1;
                                                } else {
                                                        advancesRound2=0;
                                                }
                                                gameNumber++;
                                                playingIs[ 0 ]=advancesRound1;
                                                playingIs[ 1 ]=advancesRound2;
                                        } else {
                                                if ( gameNumber==3 ) {
                                                        if ( color.equals ("red") ) {
                                                                scores[ advancesRound2 ]=15;
                                                        } else {
                                                                scores[ advancesRound1 ]=15;
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }

        public String isWinner(int column, int row, String[][] gameMatrix, String color) {
                if ( winnerHorizontal (row, column, gameMatrix) || winnerVertical (column, row, gameMatrix) || winnerDiagonal (column, row, gameMatrix) ) {
                        if ( gameNumber==numberPlayers - 1 ) {
                                actInScores (color);
                                PlayerList.getPlayers (getWinner ()).setCoins (10);
                                if(versus){versusMethodPositions ();}
                                return "true";
                        } else {
                                actInScores (color);
                                return "nextMatch";
                        }
                } else {
                        return "false";
                }
        }

        private void versusMethodPositions(){
                for( Player search : call){
                        if(!search.equals (PlayerList.getPlayers (getWinner ()))){
                                if(! Round.getCurrent ().equals (search) ) {
                                        search.setPath (playerEvents.lastPath);
                                        search.setPosition (playerEvents.lastPosition);
                                        search.movePlayer(XYAxes.getXY(search.getPath()).get(search.getPosition()));
                                }else {
                                        playerEvents.Punishment (search);
                                }
                        }
                }
        }

        public boolean winnerDiagonal(int column, int row, String[][] gameMatrix) {
                int counterA=0;
                int counterB=0;
                int y=row;
                int x=column;
                while (y >= 0 && x <= 6) {
                        if ( gameMatrix[ row ][ column ].equals (gameMatrix[ y ][ x ]) ) {
                                counterA++;
                                y--;
                                x++;
                        } else {
                                break;
                        }
                }
                y=row;
                x=column;
                while (y <= 5 && x >= 0) {
                        if ( gameMatrix[ row ][ column ].equals (gameMatrix[ y ][ x ]) ) {
                                counterB++;
                                y++;
                                x--;
                        } else {
                                break;
                        }

                }
                if ( counterA + counterB==5 ) {
                        System.out.println ("diagonal1");
                        return true;
                } else {
                        counterA=0;
                        counterB=0;
                        y=row;
                        x=column;
                        while (y >= 0 && x >= 0) {
                                if ( gameMatrix[ row ][ column ].equals (gameMatrix[ y ][ x ]) ) {
                                        counterA++;
                                        y--;
                                        x--;
                                } else {
                                        break;
                                }
                        }
                        y=row;
                        x=column;
                        while (y <= 5 && x <= 6) {
                                if ( gameMatrix[ row ][ column ].equals (gameMatrix[ y ][ x ]) ) {
                                        counterB++;
                                        y++;
                                        x++;
                                } else {
                                        break;
                                }

                        }
                        if ( counterA + counterB==5 ) {
                                System.out.println ("diagonal2");
                                return true;
                        } else {
                                return false;
                        }
                }
        }


        public boolean winnerVertical(int column, int row, String[][] gameMatrix) {
                int counter4=0;
                for ( int y=row; y < 6; y++ ) {
                        if ( gameMatrix[ y ][ column ].equals (gameMatrix[ row ][ column ]) ) {
                                counter4++;
                        } else {
                                counter4=0;
                        }
                        if ( counter4==4 ) {
                                System.out.println ("vertical");
                                return true;
                        }

                }
                return false;
        }

        public boolean winnerHorizontal(int row, int column, String[][] gameMatrix) {
                int counter4=0;
                for ( int x=0; x < 7; x++ ) {
                        if ( gameMatrix[ row ][ column ].equals (gameMatrix[ row ][ x ]) ) {
                                counter4++;
                        } else {
                                counter4=0;
                        }
                        if ( counter4==4 ) {
                                System.out.println ("horizontal");
                                return true;
                        }
                }
                return false;
        }

        private int getWinner(){
                int index = 0;
                int holdValue = scores[0];
                for(int score : scores){
                        if(score > holdValue){
                                index++;
                        }
                }
                return index;
        }
}
