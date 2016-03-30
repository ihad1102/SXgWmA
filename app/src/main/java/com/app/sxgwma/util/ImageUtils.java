package com.app.sxgwma.util;

/**
 * 图片网络访问类
 */
public class ImageUtils{

  /*  public static int computeSampleSize(BitmapFactory.Options options,
                                        int minSideLength, int maxNumOfPixels)
    {
        int initialSize = computeInitialSampleSize(options, minSideLength,
                maxNumOfPixels);

        int roundedSize;
        if (initialSize <= 8)
        {
            roundedSize = 1;
            while (roundedSize < initialSize)
            {
                roundedSize <<= 1;
            }
        } else
        {
            roundedSize = (initialSize + 7) / 8 * 8;
        }

        return roundedSize;
    }

    public static BitmapFactory.Options getOptions()
    {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        return o;
    }

    public static void resetOptions(BitmapFactory.Options o, int maxNumOfPixels)
    {
        o.inSampleSize = ImageUtils.computeSampleSize(o, -1, maxNumOfPixels);
        o.inPreferredConfig = Bitmap.Config.RGB_565;
        o.inPurgeable = true;
        o.inInputShareable = true;
        o.inJustDecodeBounds = false;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options,
                                                int minSideLength, int maxNumOfPixels)
    {
        double w = options.outWidth;
        double h = options.outHeight;

        int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
                .sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
                Math.floor(w / minSideLength), Math.floor(h / minSideLength));

        if (upperBound < lowerBound)
        {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == -1) && (minSideLength == -1))
        {
            return 1;
        } else if (minSideLength == -1)
        {
            return lowerBound;
        } else
        {
            return upperBound;
        }
    }*/
}
