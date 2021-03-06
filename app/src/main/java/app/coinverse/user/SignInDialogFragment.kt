package app.coinverse.user

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import app.coinverse.databinding.FragmentSignInBinding
import app.coinverse.databinding.FragmentSignInDialogBinding
import app.coinverse.home.HomeViewModel
import app.coinverse.utils.RC_SIGN_IN
import app.coinverse.utils.SIGNIN_TYPE_KEY
import app.coinverse.utils.SignInType
import app.coinverse.utils.SignInType.DIALOG
import app.coinverse.utils.SignInType.FULLSCREEN
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth.getInstance
import kotlinx.android.synthetic.main.fragment_sign_in_dialog.*

private val LOG_TAG = SignInDialogFragment::class.java.simpleName

class SignInDialogFragment : DialogFragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

    fun newInstance(bundle: Bundle) = SignInDialogFragment().apply { arguments = bundle }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            when (SignInType.valueOf(arguments?.getString(SIGNIN_TYPE_KEY)!!)) {
                DIALOG -> FragmentSignInDialogBinding.inflate(inflater, container, false).root
                FULLSCREEN -> FragmentSignInBinding.inflate(inflater, container, false).root
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirm.setOnClickListener {
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder()
                            .setAvailableProviders(listOf(AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN)
            if (resultCode == Activity.RESULT_OK) {
                homeViewModel.setUser(getInstance().currentUser)
                dismiss()
            } else Log.e(LOG_TAG, "Sign in fail ${IdpResponse.fromResultIntent(data)?.error}")
    }
}
