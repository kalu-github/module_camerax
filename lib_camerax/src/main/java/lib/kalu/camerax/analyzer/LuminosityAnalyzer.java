package lib.kalu.camerax.analyzer;

import android.util.Log;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;

import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/**
 * description:
 * created by kalu on 2021-03-31
 */
public class LuminosityAnalyzer implements ImageAnalysis.Analyzer {
    private long lastAnalyzedTimestamp;

    private final byte[] toByteArray(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        byte[] data = new byte[byteBuffer.remaining()];
        byteBuffer.get(data);
        return data;
    }

    public void analyze(@NotNull ImageProxy image) {
        Intrinsics.checkNotNullParameter(image, "image");
        long currentTimestamp = System.currentTimeMillis();
        if (currentTimestamp - this.lastAnalyzedTimestamp >= TimeUnit.SECONDS.toMillis(1L)) {
            ImageProxy.PlaneProxy var10000 = image.getPlanes()[0];
            Intrinsics.checkNotNullExpressionValue(var10000, "image.planes[0]");
            ByteBuffer var20 = var10000.getBuffer();
            Intrinsics.checkNotNullExpressionValue(var20, "image.planes[0].buffer");
            ByteBuffer buffer = var20;
            byte[] data = this.toByteArray(buffer);
            ArrayList pixels = new ArrayList(data.length);

            for (int i = 0; i < data.length; ++i) {
                Integer var19 = data[i] & 255;
                pixels.add(var19);
            }

            double luma = CollectionsKt.averageOfInt(pixels);
            Log.e("CameraXDemo", "Average luminosity: " + luma);
            this.lastAnalyzedTimestamp = currentTimestamp;
        }

    }
}