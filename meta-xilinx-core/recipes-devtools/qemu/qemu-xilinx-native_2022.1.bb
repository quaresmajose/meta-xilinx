require qemu-xilinx-native.inc
BPN = "qemu-xilinx"

EXTRA_OECONF:append = " --target-list=${@get_qemu_usermode_target_list(d)} --disable-tools --disable-blobs --disable-guest-agent"

PROVIDES = "qemu-native"
PACKAGECONFIG ??= "pie"

# oe-core 27260be3 introduces jack that is not available on xilinx
PACKAGECONFIG[jack] = ""
# oe-core 34afdd0b introduces png that is not available on xilinx
PACKAGECONFIG[png] = ""
# oe-core 9afb0fbf introduces debuginfo that is not available on xilinx
PACKAGECONFIG[debuginfo] = ""
# oe-core 0866acdc fixes pulseaudio that is not available on xilinx
PACKAGECONFIG[pulseaudio] = ""
# oe-core 0df2247c fixes pulseaudio that is not available on xilinx
PACKAGECONFIG[dbus-display] = ""
# oe-core a7176c3b qemu: Upgrade 8.0.4 -> 8.1.0
EXTRA_OECONF:remove = "--disable-download"
# oe-core d63cadd4 fixes pulseaudio that is not available on xilinx
PACKAGECONFIG[pipewire] = ""
# oe-core e7461826 qemu: add PACKAGECONFIG for sndio
PACKAGECONFIG[sndio] = ""
