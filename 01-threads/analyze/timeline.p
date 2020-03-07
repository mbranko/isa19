# output as png image
set terminal png size 1280,720

# save output file name
set output "`sed -n '1p' plotparams`-timeline.png"

# where to place the legend/key
set key left top

# graph title
set title "`sed -n '2p' plotparams`"

# y-axis grid
set grid y

# Specify that the x-series data is time data
set xdata time

# Specify the *input* format of the time data
set timefmt "%s"

# Specify the *output* format for the x-axis tick labels
set format x "%S"

# x-axis label
set xlabel "seconds"

# y-axis label
set ylabel "response time (ms)"

# Tell gnuplot to use tabs as the delimiter instead of spaces (default)
set datafile separator '\t'

# Plot the data
plot "`sed -n '1p' plotparams`.tsv" every ::2 using 2:5 title "response times: `sed -n '1p' plotparams`" with points
