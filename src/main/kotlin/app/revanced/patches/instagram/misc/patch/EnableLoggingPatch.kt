package app.revanced.patches.instagram.misc.patch

import app.revanced.extensions.toErrorResult
import app.revanced.patcher.annotation.*
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.instagram.misc.fingerprints.LoggingFinalFingerprint
import app.revanced.patches.instagram.misc.fingerprints.LoggingFingerprint

@Patch(false)
@Name("inst-enable-logging")
@Description("Enable all logging into logcat from Instagram")
@Compatibility([Package("com.instagram.android")])
@Version("0.0.1")
class EnableLoggingPatch : BytecodePatch(
    listOf(
        LoggingFingerprint,
        LoggingFinalFingerprint
    )
) {
    override fun execute(context: BytecodeContext): PatchResult {
        if (LoggingFingerprint.result == null && LoggingFinalFingerprint.result == null)
        {
            return LoggingFingerprint.toErrorResult();
        }
        if (LoggingFingerprint.result != null)
        {
            val method = LoggingFingerprint.result!!.mutableMethod
            method.addInstructions(
                0,
                """
                const/4 v0, 0x1
                return v0
            """
            )
        }
        if (LoggingFinalFingerprint.result != null)
        {
            val method = LoggingFinalFingerprint.result!!.mutableMethod
            method.addInstructions(
                0,
                """
                const/4 v0, 0x1
                return v0
            """
            )
        }

        return PatchResultSuccess()
    }
}