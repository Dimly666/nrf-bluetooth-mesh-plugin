package com.lebrislo.bluetooth.mesh

import android.util.Log
import com.lebrislo.bluetooth.mesh.plugin.PluginCallManager
import no.nordicsemi.android.mesh.MeshStatusCallbacks
import no.nordicsemi.android.mesh.transport.ConfigAppKeyStatus
import no.nordicsemi.android.mesh.transport.ConfigCompositionDataStatus
import no.nordicsemi.android.mesh.transport.ConfigDefaultTtlGet
import no.nordicsemi.android.mesh.transport.ConfigDefaultTtlStatus
import no.nordicsemi.android.mesh.transport.ConfigModelAppStatus
import no.nordicsemi.android.mesh.transport.ConfigNetworkTransmitSet
import no.nordicsemi.android.mesh.transport.ConfigNetworkTransmitStatus
import no.nordicsemi.android.mesh.transport.ConfigNodeResetStatus
import no.nordicsemi.android.mesh.transport.ControlMessage
import no.nordicsemi.android.mesh.transport.GenericOnOffStatus
import no.nordicsemi.android.mesh.transport.LightCtlStatus
import no.nordicsemi.android.mesh.transport.LightHslStatus
import no.nordicsemi.android.mesh.transport.MeshMessage
import no.nordicsemi.android.mesh.transport.VendorModelMessageStatus

class MeshStatusCallbacksManager(var nrfMeshManager: NrfMeshManager) : MeshStatusCallbacks {
    private val tag: String = MeshStatusCallbacksManager::class.java.simpleName

    override fun onTransactionFailed(dst: Int, hasIncompleteTimerExpired: Boolean) {

    }

    override fun onUnknownPduReceived(src: Int, accessPayload: ByteArray?) {

    }

    override fun onBlockAcknowledgementProcessed(dst: Int, message: ControlMessage) {
        Log.d(tag, "onBlockAcknowledgementProcessed")
    }

    override fun onBlockAcknowledgementReceived(src: Int, message: ControlMessage) {
        Log.d(tag, "onBlockAcknowledgementReceived")
    }

    override fun onMeshMessageProcessed(dst: Int, meshMessage: MeshMessage) {
        Log.d(tag, "onMeshMessageProcessed")
    }

    override fun onMeshMessageReceived(src: Int, meshMessage: MeshMessage) {
        Log.d(tag, "onMeshMessageReceived ${meshMessage.javaClass.simpleName}")
//        val meshManager = nrfMeshManager.meshManagerApi

        if (meshMessage is ConfigNodeResetStatus) {
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is ConfigModelAppStatus) {
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is ConfigAppKeyStatus) {
//            nrfMeshManager.onAppKeyAddStatusReceived(meshMessage)
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is ConfigCompositionDataStatus) {
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is ConfigDefaultTtlStatus){
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is ConfigNetworkTransmitStatus){
            PluginCallManager.getInstance().resolveConfigPluginCall(meshMessage)
        } else if (meshMessage is GenericOnOffStatus) {
            PluginCallManager.getInstance().resolveSigPluginCall(meshMessage)
        }



//        else if (meshMessage is GenericOnOffStatus) {
//            PluginCallManager.getInstance().resolveSigPluginCall(meshMessage)
//        } else if (meshMessage is LightHslStatus) {
//            PluginCallManager.getInstance().resolveSigPluginCall(meshMessage)
//        } else if (meshMessage is LightCtlStatus) {
//            PluginCallManager.getInstance().resolveSigPluginCall(meshMessage)
//        } else if (meshMessage is VendorModelMessageStatus) {
//            PluginCallManager.getInstance().resolveVendorPluginCall(meshMessage)
//        }

//        else if (meshMessage is GenericPowerLevelStatus) {
//            PluginCallManager.getInstance().resolveSigPluginCall(meshMessage)
//        }
    }

    override fun onMessageDecryptionFailed(meshLayer: String?, errorMessage: String?) {

    }
}
