require qemu-xilinx-native.inc

EXTRA_OECONF:append = " --target-list=${@get_qemu_system_target_list(d)}"

PACKAGECONFIG ??= "fdt alsa kvm pie"

PACKAGECONFIG:remove = "${@'kvm' if not os.path.exists('/usr/include/linux/kvm.h') else ''}"

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

DEPENDS += "pixman-native qemu-xilinx-native bison-native ninja-native meson-native"

do_install:append() {
    # The following is also installed by qemu-native
    rm -f ${D}${datadir}/qemu/trace-events-all
    rm -rf ${D}${datadir}/qemu/keymaps
    rm -rf ${D}${datadir}/icons
    rm -rf ${D}${includedir}/qemu-plugin.h
}

