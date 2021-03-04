package com.example.projetoandroid.estension

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.projetoandroid.R

// passar animações do projeto , buil constroi as navegaç~coes
private val slideLeftOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()

fun NavController.navigateWithAnimations( //nova navegação com as novas animações
        destinationId: Int,
        animation: NavOptions = slideLeftOptions
) {
    this.navigate(destinationId, null, animation)
}