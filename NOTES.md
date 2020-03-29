# Notes

Use https://github.com/Bukkit/SamplePlugin as a reference.

To compile the code, you need to have the craftbukkit jar in the api/ folder.
The PaperMC jar isn't enough.
See https://bukkit.org/threads/compilation-error.327081/.

I believe the PaperMC jar only has enough to bootstrap itself until it can
download the craftbukkit jar and apply patches to it.

The API docs are located at https://papermc.io/javadocs/paper/1.15/overview-summary.html.

To make sure jars have the right classes, do:

    jar tvf api/craftbukkit-1.15.2.jar | less

Download PaperMC here: https://papermc.io/downloads
