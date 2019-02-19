package com.example.savedataonrealtimedb.util;

import android.content.Context;
import android.net.ConnectivityManager;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by ntf-19 on 25/1/18.
 */

public class AppConstants {




   // public static InterstitialAd mInterstitialAd;

   /* public static void codeForBannerAd(final Context mContext, AdView mAdView){
        AdRequest adRequest = new AdRequest.Builder()
               *//* .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("9D89B2DA38441C34B95EEFC30E44DDD8")*//*
                .build();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                // Toast.makeText(mContext, "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                //  Toast.makeText(mContext, "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
                Log.d("AdLOadFailed","onAdFailedToLoad Banner"+errorCode);

            }

            @Override
            public void onAdLeftApplication() {
                // Toast.makeText(mContext, "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);
    }
    public static void codeForFullScreenAd(final Context mContext){
        AdRequest adBRequest = new AdRequest.Builder()

                .build();
         mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(mContext.getString(R.string.interstitial_full_screen));

            mInterstitialAd.loadAd(adBRequest);


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();


            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);


            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

            }
        });
    }
    public static void showInterstitialAd() {
        if (mInterstitialAd!=null&&mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    public static void showInterstitialAdclosed() {

    }*/


    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService (CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&    conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            System.out.println("Internet Connection Not Present");
            return false;
        }
    }
}
