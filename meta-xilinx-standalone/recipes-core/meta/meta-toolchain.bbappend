COMPATIBLE_HOST = "${HOST_SYS}"

TOOLCHAIN_TARGET_TASK:xilinx-standalone = "${@multilib_pkg_extend(d, 'packagegroup-newlib-standalone-sdk-target')}"
