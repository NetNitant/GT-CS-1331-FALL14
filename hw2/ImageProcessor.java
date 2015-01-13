public class ImageProcessor {
    private Pic originalImage;

    public ImageProcessor(Pic image) {
        originalImage = image;
    }

    public Pic greyscale() {
        Pic greyscaleImage = originalImage.deepCopy();

        for (int i = 0; i < greyscaleImage.getHeight(); i++) {
            for (int j = 0; j < greyscaleImage.getWidth(); j++) {
                Pixel currentPixel = greyscaleImage.getPixels()[i][j];

                int averageColor = (currentPixel.getRed()
                                    + currentPixel.getGreen()
                                    + currentPixel.getBlue()) / 3;

                currentPixel.setRed(averageColor);
                currentPixel.setGreen(averageColor);
                currentPixel.setBlue(averageColor);
            }
        }

        return greyscaleImage;
    }

    public Pic invert() {
        Pic invertedImage = originalImage.deepCopy();

        for (int i = 0; i < invertedImage.getHeight(); i++) {
            for (int j = 0; j < invertedImage.getWidth(); j++) {
                Pixel currentPixel = invertedImage.getPixels()[i][j];

                int newRed = 255 - currentPixel.getRed();
                int newGreen = 255 - currentPixel.getGreen();
                int newBlue = 255 - currentPixel.getBlue();

                currentPixel.setRed(newRed);
                currentPixel.setGreen(newGreen);
                currentPixel.setBlue(newBlue);
            }
        }

        return invertedImage;
    }

    public Pic noRed() {
        Pic noRedImage = originalImage.deepCopy();

        for (int i = 0; i < noRedImage.getHeight(); i++) {
            for (int j = 0; j < noRedImage.getWidth(); j++) {
                Pixel currentPixel = noRedImage.getPixels()[i][j];

                currentPixel.setRed(0);
            }
        }

        return noRedImage;
    }

    public Pic blackAndWhite() {
        Pic blackAndWhiteImage = originalImage.deepCopy();

        for (int i = 0; i < blackAndWhiteImage.getHeight(); i++) {
            for (int j = 0; j < blackAndWhiteImage.getWidth(); j++) {
                Pixel currentPixel = blackAndWhiteImage.getPixels()[i][j];

                int averageColor = (currentPixel.getRed()
                                    + currentPixel.getGreen()
                                    + currentPixel.getBlue()) / 3;

                if (averageColor > 127) {
                    currentPixel.setRed(255);
                    currentPixel.setGreen(255);
                    currentPixel.setBlue(255);
                } else {
                    currentPixel.setRed(0);
                    currentPixel.setGreen(0);
                    currentPixel.setBlue(0);
                }
            }
        }

        return blackAndWhiteImage;
    }

    public Pic maximize() {
        Pic maximizedImage = originalImage.deepCopy();

        for (int i = 0; i < maximizedImage.getHeight(); i++) {
            for (int j = 0; j < maximizedImage.getWidth(); j++) {
                Pixel currentPixel = maximizedImage.getPixels()[i][j];

                if (currentPixel.getRed() < currentPixel.getGreen()
                    || currentPixel.getRed() < currentPixel.getBlue()) {
                    currentPixel.setRed(0);
                }

                if (currentPixel.getGreen() < currentPixel.getRed()
                    || currentPixel.getGreen() < currentPixel.getBlue()) {
                    currentPixel.setGreen(0);
                }

                if (currentPixel.getBlue() < currentPixel.getRed()
                    || currentPixel.getBlue() < currentPixel.getGreen()) {
                    currentPixel.setBlue(0);
                }
            }
        }

        return maximizedImage;
    }

    public Pic overlay(Pic other) {
        Pic overlaidImage = originalImage.deepCopy();

        int maxHeight = overlaidImage.getHeight() < other.getHeight()
                        ? overlaidImage.getHeight() : other.getHeight();

        int maxWidth = overlaidImage.getWidth() < other.getWidth()
                       ? overlaidImage.getWidth() : other.getWidth();

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                Pixel currentPixel = overlaidImage.getPixels()[i][j];
                Pixel overlayPixel = other.getPixels()[i][j];

                int overlaidRed = (currentPixel.getRed()
                                   + overlayPixel.getRed()) / 2;
                int overlaidGreen = (currentPixel.getGreen()
                                     + overlayPixel.getGreen()) / 2;
                int overlaidBlue = (currentPixel.getBlue()
                                    + overlayPixel.getBlue()) / 2;

                currentPixel.setRed(overlaidRed);
                currentPixel.setGreen(overlaidGreen);
                currentPixel.setBlue(overlaidBlue);
            }
        }

        return overlaidImage;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Must enter at least one file to process!");
            System.exit(1);
        }

        ImageProcessor imageProcessor = new ImageProcessor(new Pic(args[0]));

        imageProcessor.greyscale().show();
        imageProcessor.invert().show();
        imageProcessor.noRed().show();
        imageProcessor.blackAndWhite().show();
        imageProcessor.maximize().show();

        if (args.length >= 2) {
            imageProcessor.overlay(new Pic(args[1])).show();
        }
    }
}
