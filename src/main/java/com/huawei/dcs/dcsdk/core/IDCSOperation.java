/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.dcs.dcsdk.core;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

/**
 * IDCSOperation
 *
 * @since 2022-08-05
 */
public class IDCSOperation {
    private Objct objct;



    public void good() {
       String command = System.getenv("");
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
