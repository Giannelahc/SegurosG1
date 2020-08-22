/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.controller;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Giannela HC
 */
public interface SegurosController {
    void create(@NotNull Context context);

}

