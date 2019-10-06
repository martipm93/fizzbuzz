package com.concatel.exam1.persistence.dao.impl;

import com.concatel.exam1.exceptions.FizzBuzzNullCustomException;
import com.concatel.exam1.persistence.dao.FizzBuzzFileDao;
import com.concatel.exam1.persistence.model.FizzBuzzEntry;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class FizzBuzzFileDaoImpl implements FizzBuzzFileDao<FizzBuzzEntry> {
    @Override
    public void write ( FizzBuzzEntry fizzBuzzEntry ) {
        URL res = getClass().getClassLoader().getResource("FizzBuzzRegister.txt");
        Path path = null;

        try {

            if ( fizzBuzzEntry == null ) {
                throw new FizzBuzzNullCustomException("fizzBuzzEntry");
            }

            path = Paths.get(res.toURI());

        } catch ( FizzBuzzNullCustomException e ) {
            e.printStackTrace();
        } catch ( URISyntaxException e ) {
            e.printStackTrace();
        }

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), true)) )
        {
            writer.write(fizzBuzzEntry.toString().concat("\n\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
