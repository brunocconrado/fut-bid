package br.com.futbid.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futbid.service.ImageService;
import br.com.futbid.service.exception.ServiceException;
import br.com.futbid.service.thread.ImageLoader;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageLoader imageLoader;

    @Override
    public void loadImage(JPanel panel, String url) {

	try {
	    imageLoader.setPanel(panel);
	    imageLoader.setUrl(new URL(url));
	    imageLoader.start();
	} catch (MalformedURLException e) {
	    throw new ServiceException(e);
	}

    }

}
