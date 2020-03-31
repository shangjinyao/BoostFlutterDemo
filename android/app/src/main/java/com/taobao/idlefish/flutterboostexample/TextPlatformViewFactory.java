package com.taobao.idlefish.flutterboostexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class TextPlatformViewFactory extends PlatformViewFactory {

    public TextPlatformViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
    }

    @Override
    public PlatformView create(Context context, int i, Object o) {
        return new TextPlatformView(context);
    }

    private static class TextPlatformView implements PlatformView {

        private TextView platformTv;

        public TextPlatformView(Context context) {
            platformTv = new TextView(context);
            platformTv.setText("TextView");
            platformTv.setTextColor(Color.GREEN);
            platformTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    context.startActivity(new Intent(context, NativePageActivity.class));
                }
            });
        }

        @Override
        public View getView() {
            return platformTv;
        }

        @Override
        public void dispose() {

        }
    }
}
