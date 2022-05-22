package com.example.demoapplication.base

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.demoapplication.R
import com.example.demoapplication.utills.*
import com.glowdubai_staff.base.PreferenceHelper.customPrefs
import com.glowdubai_staff.service.NetworkViewModel
import com.glowdubai_staff.service.ProgressUtils
import com.glowdubai_staff.utils.*



abstract class BaseFragment<Binding : ViewDataBinding/*,ViewModel : BaseViewModel*/> : Fragment()/*,
    EasyPermissions.PermissionCallbacks*/ {

    protected lateinit var bindingObject: Binding
    private var sentToSettings = false
    lateinit var prefs: SharedPreferences
    var mProgressUtil: ProgressUtils? = null
    val GALLERY_IMAGE_REQ_CODE = 102


    private val networkViewModel: NetworkViewModel by lazy {
        ViewModelProvider(this)[NetworkViewModel::class.java]
    }


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        this.activity = context as GoodinActivity?
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        bindingObject = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        prefs = requireActivity().customPrefs()
        initView()
        setListner()
        return bindingObject.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initProgress()
        listenNetworkState()
    }

    private fun initProgress() {
        if (mProgressUtil == null)
            mProgressUtil = ProgressUtils(lifecycle, requireContext())
    }

    fun showProgress(
        isCancelable: Boolean = false,
        message: String = "",
        mainMessage: String = "",
    ) {
        requireActivity().runOnUiThread {
            initProgress()
            mProgressUtil?.show(isCancelable, message, mainMessage)
        }
    }

    fun hideProgress() {
        requireActivity().runOnUiThread {
            initProgress()
            mProgressUtil?.hide()
        }
    }

    open fun initToolbar(
        textName: AppCompatTextView = bindingObject.root.findViewById(R.id.txtTitlet),
        name: String = "",
        isImgBack: Boolean = false,
        imageBack: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgBack),
        isProfile: Boolean = true,
        ImgProfile: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgProfile),
        isSearch: Boolean = false,
        ImgSearch: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgSearch),
        imageDrawbleSettings: Int = R.drawable.ic_search,
    ) {
        //textName.isRTL(prefs.isAR())

        textName.text = name
        imageBack?.visibilityGone(isImgBack)
//        ImgProfile?.circularImage(
//            prefs.getString(AppConstants.PREFERECENCE_UTILLS.PROFILEIMAGE, "").toString()
//        )
        ImgProfile?.inVisibilityGone(isProfile)
        ImgSearch?.visibilityGone(isSearch)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        imageBack!!.setOnSingleClickListener {
            findNavController().navigateUp(appBarConfiguration)
        }


    }


    private fun listenNetworkState() {
        networkViewModel.networkLiveData.observe(requireActivity(),
            { t ->
                if (!t!!) {
                    if (isAdded)
                        onNetWorkChange(t)
                }
            })
    }

    /**
     * on network change this method will call
     */
    abstract fun onNetWorkChange(onNetworkChange: Boolean)
    abstract fun setListner()


    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

    protected abstract fun initView()

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String?>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
//
//    }
//
//    override fun onPermissionsGranted(requestCode: Int, perms: List<String?>) {
//
//    }
//
//    override fun onPermissionsDenied(requestCode: Int, perms: List<String?>) {
//        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
//            //AppSettingsDialog.Builder(this).build().show()
//
////            AppSettingsDialog.Builder(this).setThemeResId(R.style.AlertDialogCustom)
////                .setTitle(R.string.str_permission_req)
////                .setRationale(getString(R.string.str_permission_req_title)).build().show()
//
//
//            val dialog = Dialog(requireContext())
//            dialog.setCancelable(false)
//
//            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
//            val dialogLayout =
//                LayoutInflater.from(requireContext()).inflate(R.layout.dialog_logout, null)
//            dialog.window!!.setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            dialog.window!!.setGravity(Gravity.CENTER)
//            val back = ColorDrawable(Color.TRANSPARENT)
//            val inset = InsetDrawable(back, 40)
//            dialog.window!!.setBackgroundDrawable(inset)
//            dialogLayout.imgLogout.setImageDrawable(requireContext().getDrawable(R.drawable.ic_permission_allow))
//            dialogLayout.txtYes.text = getString(R.string.str_okay)
//            dialogLayout.txtLogout.text = getString(R.string.str_permission_req_title)
//            dialogLayout.txtNo.text = getString(R.string.str_cancle)
//            dialogLayout.txtYes.setOnClickListener {
//                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                    .setData(Uri.fromParts("package", requireContext().packageName, null))
//                startActivity(intent)
//                dialog.dismiss()
//            }
//            dialogLayout.txtNo.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.window!!.attributes.windowAnimations = R.style.DialogAnimations
//            dialog.setContentView(dialogLayout)
//            dialog.show()
//
//        }
//    }
//
//
//    @AfterPermissionGranted(123)
//    fun checkCamerapermission(isForCamera : Boolean= false): Boolean {
//        Log.e("camera permission",isForCamera.toString())
//        var perms = arrayOf<String>()
//
//        perms = if(isForCamera){
//            arrayOf(Manifest.permission.CAMERA)
//        }else{
//            arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
//        }
//
////        if (EasyPermissions.hasPermissions(requireContext(), *perms))
////        var checkPermission = false
////        for (i in perms.indices){
////            if (perms[i] == Manifest.permission.CAMERA && EasyPermissions.hasPermissions(requireContext(),Manifest.permission.CAMERA)){
////                checkPermission = true
////            }else if (perms[i] == Manifest.permission.READ_EXTERNAL_STORAGE && EasyPermissions.hasPermissions(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)){
////                checkPermission = true
////            }else{
////                checkPermission = false
////                break
////            }
////        }
//////
////        return checkPermission
//
//        if (EasyPermissions.hasPermissions(requireContext(), *perms)) {
//            return true
//        } else {
//            EasyPermissions.requestPermissions(
//                this, getString(R.string.str_need_permission), GALLERY_IMAGE_REQ_CODE, *perms
//            )
//        }
//        return false
//    }
}