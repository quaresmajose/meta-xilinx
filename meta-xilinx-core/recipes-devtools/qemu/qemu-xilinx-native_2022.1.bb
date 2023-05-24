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
