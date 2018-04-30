package com.vexigon.libraries.onboarding.sample;

/*
 * Copyright 2017 Vexigon, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vexigon.libraries.onboarding.obj.Page;
import com.vexigon.libraries.onboarding.obj.selfselect.BundledListItem;
import com.vexigon.libraries.onboarding.obj.selfselect.SSPage;
import com.vexigon.libraries.onboarding.obj.selfselect.User;
import com.vexigon.libraries.onboarding.obj.selfselect.UserPage;
import com.vexigon.libraries.onboarding.sampleapp.R;
import com.vexigon.libraries.onboarding.ui.fragments.BenefitsFragment;
import com.vexigon.libraries.onboarding.ui.models.SelfSelectModel;
import com.vexigon.libraries.onboarding.ui.models.TopUserBenefitsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.demo:
                new TopUserBenefitsModel(this)
                        .setupSlides(
                                new Page("分享功能上线", "和家人朋友分享你的精彩", R.drawable.icon_guide1),
                                new Page("全新界面升级", "新视觉，新体验", R.drawable.icon_guide2),
                                new Page("设备绑定机制", "主人&访客权限分离，让生活更安全", "开始体验",R.drawable.bg_button, R.drawable.icon_guide3)
                        ).setBackgroundRes(new int[]{R.mipmap.bg_guide,R.mipmap.bg_guide,R.mipmap.bg_guide}).launch();
                break;
            case R.id.demo2:
                ArrayList<User> users = new ArrayList<>();
                users.add(0, new User("Andrew Quebe", "andrewquebe@vexigon.com", R.mipmap.ic_launcher));
                users.add(1, new User("Andrew Quebe", "andrewquebe@vexigon.com", R.mipmap.ic_launcher));
                users.add(2, new User("Andrew Quebe", "andrewquebe@vexigon.com", R.mipmap.ic_launcher));

                ArrayList<BundledListItem> bundledListItems = new ArrayList<>();
                bundledListItems.add(0, new BundledListItem("Item", "An item", R.mipmap.ic_launcher));
                bundledListItems.add(1, new BundledListItem("Item", "An item", R.mipmap.ic_launcher));
                bundledListItems.add(2, new BundledListItem("Item", "An item", R.mipmap.ic_launcher));

                new SelfSelectModel(this)
                        .setupSlides(
                                new UserPage(
                                        R.mipmap.ic_launcher,
                                        users),
                                new SSPage(
                                        "Title",
                                        "Subtitle",
                                        bundledListItems,
                                        null,
                                        null
                                )
                        )
                        .launch();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("leleTest","resultCode="+resultCode);
    }
}
