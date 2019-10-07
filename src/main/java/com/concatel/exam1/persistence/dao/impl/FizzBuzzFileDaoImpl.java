package com.concatel.exam1.persistence.dao.impl;

import com.concatel.exam1.exceptions.FizzBuzzNullCustomException;
import com.concatel.exam1.persistence.dao.FizzBuzzFileDao;
import com.concatel.exam1.persistence.model.FizzBuzzEntry;
import com.concatel.exam1.web.controller.FizzBuzzController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(FizzBuzzController.class);

    @Override
    public void write ( FizzBuzzEntry fizzBuzzEntry ) {

        logger.info("Initiation of the 'write' method of FizzBuzzFileDaoImpl.");

        URL res = getClass().getClassLoader().getResource("FizzBuzzRegister.txt");
        Path path = null;

        try {

            if ( fizzBuzzEntry == null ) {
                throw new FizzBuzzNullCustomException("fizzBuzzEntry");
            }

            path = Paths.get(res.toURI());

        } catch ( FizzBuzzNullCustomException e ) {
            logger.error(e.getMessage());
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
        logger.info("End of the 'findOne' method of FizzBuzzController.");
    }
}
