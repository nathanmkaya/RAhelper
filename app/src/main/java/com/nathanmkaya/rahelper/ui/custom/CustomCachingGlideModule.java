package com.nathanmkaya.rahelper.ui.custom;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by nathan on 4/28/17.
 */

public class CustomCachingGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int cacheSize500MegaBytes = 524288000;
        String externalDirectory = Environment.getExternalStorageDirectory().getPath();
        StatFs fs = new StatFs(externalDirectory);
        int cacheSize = fs.getAvailableBlocks() / 2;
        builder.setDiskCache(new DiskLruCacheFactory(externalDirectory, "RAhelper", cacheSize));
        //builder.setDiskCache(new InternalCacheDiskCacheFactory(context, "RAhelper", cacheSize500MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
