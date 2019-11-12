/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrs_2_2019.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author kacpe
 */
public class RatingDAO
{
    private static final String RATING_SOURCE = "data/ratings_rf.dat";
    
    public int getRating( int userId, int movieId) throws IOException
    {
        File ratingSource = new File(RATING_SOURCE);
        
        try(RandomAccessFile raf = new RandomAccessFile(ratingSource, "r"))
        {
            for(int i = 0; i < raf.length(); i += 12)
            {
                raf.seek(i);
                int mvId = raf.readInt();
                int usId = raf.readInt();
                if(userId==usId && movieId==mvId)
                {
                    return raf.readInt();
                }
            }
            throw new IllegalArgumentException("no rating found for userID" + userId + "and movieId" + movieId);
        }
    }
    
    public void createRating(int movieId, int userId, int rating) throws  IOException
    {
        File ratingSource = new File(RATING_SOURCE);
        
        try(RandomAccessFile raf = new RandomAccessFile(ratingSource, "rw"))
        {
            raf.seek(raf.length());
            raf.writeInt(movieId);
            raf.writeInt(userId);
            raf.writeInt(rating);
        }
    }
    
    
    public static void main(String[] args) throws IOException
    {
        RatingDAO ratingDAO = new RatingDAO();
        ratingDAO.createRating(1, 100, 1);
        ratingDAO.createRating(2, 101, 3);
        ratingDAO.createRating(3, 102, -5);
        ratingDAO.createRating(4, 103, 8);
        ratingDAO.createRating(5, 104, 9);
        
        int rating = ratingDAO.getRating(102, 3);
        System.out.println("rating is" + rating);
        
        
    }
}
