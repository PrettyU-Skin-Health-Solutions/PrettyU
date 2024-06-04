package com.capstone.prettyU.View.Activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.capstone.prettyU.BackEnd.Utilities.Constant.AnimationConstant.AnimationProperty
import com.capstone.prettyU.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playAnimation()
    }

    // TODO: set animasi
    private fun playAnimation() {
        val const = AnimationProperty
        // set posisi awal sebelum start
        binding.inputLoginUsername.translationX = 400f
        binding.edLoginUsername.translationX = 400f
        binding.inputLoginPassword.translationX = -400f
        binding.edLoginPassword.translationX = -400f
        binding.btnSignIn.translationY = 1200f

        val tvNotif =
            ObjectAnimator.ofFloat(binding.tvNotif, View.ALPHA, 0f, 1f)
                .setDuration(const.animDurationShort)

        val inputLoginUsername =
            ObjectAnimator.ofFloat(binding.inputLoginUsername, View.TRANSLATION_X, 400f, 0f)
                .setDuration(const.animDurationShort)

        val edLoginUsername =
            ObjectAnimator.ofFloat(binding.edLoginUsername, View.TRANSLATION_X, 400f, 0f)
                .setDuration(const.animDurationShort)

        val inputLoginPassword =
            ObjectAnimator.ofFloat(binding.inputLoginPassword, View.TRANSLATION_X, -400f, 0f)
                .setDuration(const.animDurationShort)

        val edLoginPassword =
            ObjectAnimator.ofFloat(binding.edLoginPassword, View.TRANSLATION_X, -400f, 0f)
                .setDuration(const.animDurationShort)

        val btnSignIn = ObjectAnimator.ofFloat(binding.btnSignIn, View.TRANSLATION_Y, 1200f, 0f)
            .setDuration(const.animDurationShort)

        val pairUsername = AnimatorSet().apply {
            playTogether(inputLoginUsername, edLoginUsername)
        }
        val pairPassword = AnimatorSet().apply {
            playTogether(inputLoginPassword, edLoginPassword)
        }
        val pairAll = AnimatorSet().apply {
            playTogether(pairUsername, pairPassword, btnSignIn)
        }

        AnimatorSet().apply {
            playSequentially(tvNotif, pairAll)
            start()
        }
    }
}