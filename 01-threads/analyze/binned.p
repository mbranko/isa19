# output as png image
set terminal png size 1280,720

# save output file name
set output "`sed -n '1p' plotparams`-binned.png"

# where to place the legend/key
set key left top

# graph title
set title "`sed -n '2p' plotparams`"

# y-axis grid
set grid y

# x-axis label
# set xlabel "seconds"

# y-axis label
set ylabel "response time (ms)"

#plot data from "out.data" using column 9 with smooth sbezier lines
plot "`sed -n '1p' plotparams`.tsv" using 9 smooth sbezier with lines title "`sed -n '1p' plotparams`"

